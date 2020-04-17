#!/usr/bin/env bash

# 建议使用 "keytool -importkeystore -srckeystore jhy-release-key.jks -destkeystore jhy-release-key.jks -deststoretype pkcs12" 迁移到行业标准格式 PKCS12。

keytool -importkeystore -srckeystore privateKeys.store -destkeystore privateKeys.store -deststoretype pkcs12
