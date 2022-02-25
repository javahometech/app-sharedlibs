def call(ip,user,credId){
  sshagent([credId]) {
    sh "scp -o StrictHostKeyChecking=no target/*.war ${user}@${ip}:/opt/tomcat8/webapps/app.war"
    sh "ssh ${user}@${ip} /opt/tomcat8/bin/shutdown.sh"
    sh "ssh ${user}@${ip} /opt/tomcat8/bin/startup.sh"
   }
}
