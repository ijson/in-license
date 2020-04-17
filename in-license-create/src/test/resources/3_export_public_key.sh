#!/usr/bin/env bash
# 3 提取公钥证书

keytool -export -alias CoMarkdown -file CoMarkdown.cer -keystore privateKeys.store
