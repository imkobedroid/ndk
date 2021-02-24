//
// Created by 董仕洪 on 2021/2/24.
//
#include <jni.h>
#include <main.h>
#include <string>
#include <iostream>


jstring test(jstring j) {
    return j;
}


extern "C"
JNIEXPORT jstring JNICALL
Java_com_imc_ndkcmake_MainActivity_test(JNIEnv *env, jobject thiz, jstring encrypted) {
    jstring s = test(encrypted);
    return s;
}





