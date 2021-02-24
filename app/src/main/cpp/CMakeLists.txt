#1.cmake verson，指定cmake版本
cmake_minimum_required(VERSION 3.4.1)

#2.project name，指定项目的名称，一般和项目的文件夹名称对应
PROJECT("NdkCmake")


#3.head file path，头文件目录
INCLUDE_DIRECTORIES(head)

#4.source directory，源文件目录
AUX_SOURCE_DIRECTORY(cpp source)


#打包使用的版本
SET(CMAKE_BUILD_TYPE "Release")

#打包出来的文件名加后缀
set(CMAKE_RELEASE_POSTFIX "_release")
#set(CMAKE_DEBUG_POSTFIX "_debug")


#将优化程度最高需要设置 -O3 ，最低的是 -O0 ，添加调试信息的参数是 -g  -ggdb，如果不添加这个参数，调试信息就不会被包含在生成的二进制中
SET(CMAKE_CXX_FLAGS_RELEASE "$ENV{CXXFLAGS} -O0 -Wall")
#打包出来的so库存放的位置
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/jniLibs/${ANDROID_ABI})
#上级文件夹的写法
#set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/../jniLibs/${ANDROID_ABI})


add_library(

        #打包出来的so库名称
        test-lib-name

        #SHARED,动态库（.so） STATIC,静态库(.a)
        #静态库的代码在编译过程中已经被载入可执行程序,因此体积比较大。
        #动态库(共享库)的代码在可执行程序运行时才载入内存，在编译过程中仅简单的引用，因此代码体积比较小
        SHARED

        # 打包的主函数文件
        source/main.cpp
)


#VERSION 指代动态库版本,SOVERSION 指代 API 版本。
SET_TARGET_PROPERTIES(test-lib-name PROPERTIES VERSION 1.2 SOVERSION 1)