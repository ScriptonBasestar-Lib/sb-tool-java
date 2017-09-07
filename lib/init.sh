#!/usr/bin/env bash
echo ADD MAVEN local-lib FILES..

mvn install:install-file -Dfile=cnspay_lite-0.1.1.8.jar -DgroupId=kr.co.lgcns -DartifactId=lgcns-api -Dversion=0.1.1.8 -Dpackaging=jar -Dscope-system
mvn install:install-file -Dfile=connectMPay_v2.0.3.jar -DgroupId=com.lgcns -DartifactId=lgcns-mpay -Dversion=2.0.3 -Dpackaging=jar -Dscope-system
mvn install:install-file -Dfile=cos-05Nov2002.jar -DgroupId=com.oreilly -DartifactId=servlet-lib -Dversion=05Nov2002 -Dpackaging=jar -Dscope-system
mvn install:install-file -Dfile=CreditCard32.jar -DgroupId=com.nas -DartifactId=v7 -Dversion=1 -Dpackaging=jar -Dscope-system
mvn install:install-file -Dfile=easypay_java_client17.jar -DgroupId=com.kicc -DartifactId=easypayclient17 -Dversion=1.0 -Dpackaging=jar -Dscope-system
mvn install:install-file -Dfile=ExecureCrypto_v1.0.jar -DgroupId=com.extrus -DartifactId=extrus-ExecureCrypto -Dversion=1.0 -Dpackaging=jar -Dscope-system
mvn install:install-file -Dfile=FDIKCryptoSender_v1.0.jar -DgroupId=com.extrus -DartifactId=extrus-DFIKCryptoSender -Dversion=1.0 -Dpackaging=jar -Dscope-system
mvn install:install-file -Dfile=mpay_merchant_encoder_1.0.jar -DgroupId=com.lgcns.kmpay -DartifactId=mpay-encoder -Dversion=1.0 -Dpackaging=jar -Dscope-system
mvn install:install-file -Dfile=mpay_shopping_merchant_v0.4.7.jar -DgroupId=com.lgcns.kmpay -DartifactId=mpay-merchant -Dversion=0.4.7 -Dpackaging=jar -Dscope-system
mvn install:install-file -Dfile=ojdbc14.jar -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.4.0 -Dpackaging=jar -Dscope-system
mvn install:install-file -Dfile=PHKEncrypt-0.0.1.jar -DgroupId=com.pizzahut -DartifactId=utility -Dversion=0.0.1 -Dpackaging=jar -Dscope-system

sleep 10s