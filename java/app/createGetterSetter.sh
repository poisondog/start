#!/bin/bash

sed -i 's/\(\s*private\s*\(\S*\)\s*\(\S*\);\)/\1\npublic \2 get\u\3() {\nreturn \3;\n}\npublic void set\u\3(\2 \3) {\nthis.\3 = \3;\n}\n/g' $1
