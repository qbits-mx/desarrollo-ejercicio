mvn clean verify sonar:sonar \
    -Dsonar.login=7d4850db0b941d2a12646cff50fc9517ebc3a7a9 \
    -Dsonar.host.url=https://sonarcloud.io \
    -Dsonar.organization=kix-mx \
    -Dsonar.projectKey=kix-mx
