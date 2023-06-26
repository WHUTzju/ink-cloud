APP_NAME='ink-web-1.1.jar'
pid=` ps -ef | grep $APP_NAME | grep -v grep | awk '{print $2}' `
#如果不存在返回1 ，存在返回0
#echo "pid=  $pid ,stopping "
#kill -9 `ps -ef | grep web-1.0-SNAPSHOT.jar | grep -v grep | awk '{print $2}'
if [ -z "$pid" ] ; then
        echo "${APP_NAME} is not running"
else
        echo "pid=  $pid ,stopping "
kill -9 $pid
fi