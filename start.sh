#! /bin/bash
nohup java -jar -Dserver.port=12001 -Dspring.profiles.active=prod  ink-web-1.1.jar &
