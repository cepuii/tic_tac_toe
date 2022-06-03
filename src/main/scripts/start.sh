#!/usr/bin/env sh
java -jar ${project.build.finalName}.jar
echo "Press any key to resume ..."
read -r test