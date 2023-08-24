#include <stdio.h>
#include "../include/NativeCaller.h"

JNIEXPORT void JNICALL Java_org_owls_jni_NativeCaller_hello
  (JNIEnv* env, jobject obj)
{
    printf("hello\n");
    return;
}