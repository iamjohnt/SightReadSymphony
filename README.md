# Sight Read Symphony!

### Practice sight reading, using a Midi Keyboard!

keyboard required

![](https://raw.githubusercontent.com/iamjohnt/SuperSightRead/develop/src/main/resources/images/notes_screen.gif)
![](https://github.com/iamjohnt/SuperSightRead/blob/develop/src/main/resources/images/notes_piano.gif)

# How to play
1. Start the game, select play random generated notes
2. Plug in physical midi device via USB, and select it
3. Choose game parameters (if don't know much music theory, just set default)
4. Practice playing the notes!

# Features
* Treble and bass clef!
* Key signatures!
* Accidentals! (ie sharps and flats)
* Note name displayed next to note!

![](https://raw.githubusercontent.com/iamjohnt/SuperSightRead/develop/src/main/resources/images/chords_screen.gif)
![](https://raw.githubusercontent.com/iamjohnt/SuperSightRead/develop/src/main/resources/images/chords_piano.gif)

# Potential Future Updates
* Parsing queue of notes from a midi file on disk
* Intervals and chords
* Virtual Keyboard
* Using JLink to bundle partial JRE with jar, and possibly wrapping in EXE, to allow for easier installation and running

# Installation

#### Run from jar
1. Install Java JDK 15 or above, and set the JAVA HOME environment variable
2. Within the repo root, download the build.zip file, and extract
3. In command line, CD to directory holding SightReadSymphony.jar
4. Execute command `java -jar SightReadSymphony.jar` 

#### Run source code in Intellij
1. Install Java JDK 15 or above, configure IDE to use it
2. Clone this repo
3. Sync buildscript.gradle (if doesn't work, try invalidate and restart caches option)
4. Run straight from IDE (fyi, the main method is in controller.Launcher)

#### Run source code Eclipse
1. Install Java JDK 15 or above, configure IDE to use it
2. Clone this repo
3. Import the project folder as gradle project
4. Sync buildscript.gradle (may need to clean first)
5. Delete the module-info.java (this file is necessary using Intellij, but breaks the app in Eclipse for some reason) 
6. Run straight from IDE (fyi, the main method is in controller.Launcher) 

# Known issues

* Rarely occuring, sometimes a pressed note will register as a different note
* Attempting to execute all the unit tests, using Gradle test build script will fail, outputting "Test events were not recieved". The work-around is to execute the tests using your IDE instead of Gradle. 

# Documentation for developers

See the javadoc in build.zip archive, or sightreadsymphony_build folder
