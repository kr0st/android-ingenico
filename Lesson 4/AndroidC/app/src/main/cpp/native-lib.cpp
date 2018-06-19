#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_sudo_den_androidc_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_sudo_den_androidc_MainActivity_return10(JNIEnv *env, jobject instance) {
    return 10;

}