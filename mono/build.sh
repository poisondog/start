#!/bin/bash
mcs HelloWorld.cs
# mcs HelloWorld.cs -r:System.Windows.Forms.dll
# mcs HelloWorld.cs -pkg:gtk-sharp-2.0

mono HelloWorld.exe

