Sprint2
=======

1:  Download Maven : http://maven.apache.org/download.cgi
      Download version 3.1.1 tar.gz file
      
2:  Extract the tar into the PSD3-Prototype folder.

3:  in the maven folder, create a new directory called Sprint2

4:  In the Sprint2 folder: export PATH=/users/level3/<YOURSTUDENTID>/PSD3-Prototype/apache-maven-3.1.1
      /bin:$PATH
      
5:  Type mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=team-u -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

6:  A new directory will be created, team-u. cd into team-u

7:  type: mvn package

8:  java -cp target/team-u-1.0-SNAPSHOT.jar com.mycompany.app.App will print out "hello world"!

9:  
