import sys
import re

filename = sys.argv[1]
moveRegex = sys.argv[2]

first = -1;
originalFile = open(filename, "r")
originalLines = originalFile.readlines()
matchLines = []
for i in range(0, len(originalLines), 1):
	if re.search(moveRegex, originalLines[i]):
		if first < 0:
			first = i
		matchLines.append(originalLines[i])
originalFile.close()

newLines = []
for line in originalLines:
	if not re.search(moveRegex, line):
		newLines.append(line)

matchLines.reverse()
for line in matchLines:
	newLines.insert(first, line)

newFile = open(filename, "w")
for line in newLines:
	newFile.write(line)
newFile.close()
