#!/bin/bash

#第一步：进入到指定目录
cd ffmpeg-3.4

#第二步：指定NDK路径(编译什么样的平台->采用什么样的平台编译器)
#Android平台NDK技术->做C/C++开发->编译Andrroid平台下.so动态库
#注意：放在英文目录(中文目录报错)
#修改一：修改为你自己NDK存放目录
NDK_DIR=/Users/yangshaohong/Desktop/tools/eclipse/android-ndk/android-ndk-r10e

#第三步：配置Android系统版本(支持最小的版本)
#指定使用NDK Platform版本(对应系统版本)
SYSROOT=$NDK_DIR/platforms/android-18/arch-arm

#第四步：指定编译工具链->(通俗：指定编译器)->CPU架构（Android手机通用的CPU架构类型）：armeabi
TOOLCHAIN=$NDK_DIR/toolchains/arm-linux-androideabi-4.9/prebuilt/darwin-x86_64

#第五步：指定CPU平台架构类型->手机主流架构类型->ARM架构类型
#指定编译后的安装目录
ARCH=arm
ADDI_CFLAGS="-marm"

#第六步：指定编译成功之后，.so动态库存放位置
#修改二：这个目录你需要修改为你自己目录
PREFIX=/Users/yangshaohong/Desktop/ffmpeg-android/android-build/$ARCH

#第七步：编写执行编译脚本->调用FFmpeg进行配置
#定义了Shell脚本函数(方法)
#编译一部分（编译：编解码库->核心库、工具库、视频像素数据处理库、音频采样数据处理库等等...）
#你是如何知道这些库需要编译，那个库不需要编译？
#教你方法?
#有两种方式你可以查看
#方式一：命令行查看
#方式二：通过打开文件查看

#funcation->表示Shell脚本语言中的方法定义
function build_armeabi
{
./configure \
--prefix=$PREFIX \
--enable-shared \
--enable-gpl \
--disable-static \
--disable-doc \
--disable-ffmpeg \
--disable-ffplay \
--disable-ffprobe \
--disable-ffserver \
--disable-doc \
--disable-symver \
--enable-small \
--enable-libx264  \
--cross-prefix=$TOOLCHAIN/bin/arm-linux-androideabi- \
--target-os=android \
--arch=$ARCH \
--enable-cross-compile \
--sysroot=$SYSROOT \
--extra-cflags="-Os -fpic $ADDI_CFLAGS" \
--enable-pic \
$ADDITIONAL_CONFIGURE_FLAG

#编译
make clean
make -j4
make install
}

#第八步：执行函数->开始编译
build_armeabi
echo "Android armeabi builds finished"

