#!/bin/bash -li

echo $payload > payload.txt

action=`python -c 'import json, os; d = json.loads(open("payload.txt").read()); print d["action"]'`

if [ $action != "opened" ] || [ $action != "reopened" ] || [ $action != "edited" ]; then exit ; fi

curl_url=`python -c 'import json, os; d = json.loads(open("payload.txt").read()); print d["pull_request"]["statuses_url"]'`
pr_branch=`python -c 'import json, os; d = json.loads(open("payload.txt").read()); print d["pull_request"]["head"]["ref"]'`

git clone -b $pr_branch --single-branch https://github.com/depromeet/8th-final-team5-backend.git

cd 8th-final-team5-backend

result=`echo \`./mvnw test\` | grep -q "BUILD FAILURE"; echo $?`

if [ $result == "1" ]; then \
	curl "${curl_url}" \
  		-H "Content-Type: application/json" \
  		-H "Authorization: token <TOKEN>" \
  		-X POST \
  		-d "{\"state\": \"success\",\"context\": \"continuous-integration/jenkins\", \"description\": \"Jenkins\", \"target_url\": \"http://20.194.0.141/job/dangdang_ci/$BUILD_NUMBER/console\"}"; \
else \
	curl "${curl_url}" \
  		-H "Content-Type: application/json" \
  		-H "Authorization: token <TOKEN>" \
  		-X POST \
  		-d "{\"state\": \"failure\",\"context\": \"continuous-integration/jenkins\", \"description\": \"Jenkins\", \"target_url\": \"http://20.194.0.141/job/dangdang_ci/$BUILD_NUMBER/console\"}"; \
fi
