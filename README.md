# JNI 테스트

## 구성
 프로젝트는 src 밑에 main/test 와 동등한 레벨에 native 를 구성한다.
- [Maven native plugin](https://www.mojohaus.org/maven-native/native-maven-plugin/) 의 구성을 따름

## 특이 사항
JNI 같은 경우 cli 명령어를 많이 수행하게 되는데 실행하는 위치에 따라 결과가 변할 수 있다. 이 프로젝트의 경우, 언어에 따라 cli 사용 위치가 아래와 같이 다르다.

- java: `src/main/java`
- C: `src/native`

#### Windows 환경
Windows가 32bit 냐 64bit 냐에 따라 다른 `g++` 를 사용해야 한다. 64 bit 를 대상으로 빌드하는 경우는 [MinGW-w64 for 64bit](https://sourceforge.net/projects/mingw-w64/) 로 설치해야 한다.

## 빌드
Windows64 환경을 가정한다
### java 
##### 헤더 만들기
```
$ javah -jni -o NativeCaller.h org.owls.jni.NativeCaller
```
생성된 `NativeCaller.h` 를 `src/main/native/include` 이하로 이동한다
### C
```
$ g++ -c -m64 -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" .\source\native.c -o native.o
$ g++ -shared -m64 -o NativeCaller.dll native.o -Wl,--add-stdcall-alias
```
## 기동
Intellij 의 경우, VM options 에 `-Djava.library.path={라이브러리(dll/so) 경로}` 를 추가하면 된다.