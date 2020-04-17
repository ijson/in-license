#!/usr/bin/env bash

# 提取公钥文件

keytool -import -alias CoMarkdown -file CoMarkdown.cer -keystore publicCerts.store
