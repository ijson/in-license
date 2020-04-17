#!/usr/bin/env bash
#  -genkeypair  表示生成密钥
# -keyalg      指定密钥算法,这里指定为RSA算法。
# -keysize     指定密钥长度,默认1024位,这里指定为2048位。
# -sigalg      指定数字签名算法,这里指定为SHA1withRSA算法。
# -validity    指定证书有效期,这里指定为36000天。
# -alias       指定别名,这里是www.ijson.com
# -keystore    指定密钥库存储位置，这里是d:/boss.keystore
# -dname       CN 名字 ，OU 组织单位，O 组织名称 L 城市 ST 省


# 1. 生成私钥

# keytool -genkeypair -keyalg RSA -keysize 2048 -sigalg SHA1withRSA  -alias CoMarkdown -keystore privateKeys.store -validity 365
keytool -genkeypair -keyalg RSA -keysize 2048 -sigalg SHA1withRSA -alias CoMarkdown -keystore privateKeys.store -validity 365 -dname "CN=CUIYONGXU, OU=IJSON, O=IJSON, L=BEIJING, ST=BEIJING, C=CN"
