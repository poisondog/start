#!/bin/bash
# mcs HelloWorld.cs
# mcs HelloWorld.cs -r:System.Windows.Forms.dll
# mcs HelloWorld.cs -pkg:gtk-sharp-2.0
mcs -target:library -out:poisondog.dll src/main/cs/*.cs
mcs -r:poisondog.dll HelloWorld.cs

mono HelloWorld.exe

