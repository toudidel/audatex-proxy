Download jasypt from https://sourceforge.net/projects/jasypt/files/

./encrypt.sh input="login" password=foobar
./encrypt.sh input="password" password=foobar


export JASYPT_ENCRYPTOR_PASSWORD=foobar
mvn spring-boot:run

or

mvn spring-boot:run -Djasypt.encryptor.password=foobar