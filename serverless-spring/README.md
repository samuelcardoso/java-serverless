1. Start docker
2. Build
   normal: mvn clean install
   native: mvn -Pnative spring-boot:build-image
3. Extract binary
   docker cp "<container_id>:/workspace/" "./"
