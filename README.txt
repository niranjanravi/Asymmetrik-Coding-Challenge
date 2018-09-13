To run this program, run the "main" function in Main.java. 
This will open up a REPL (read-eval-print-loop) that allows the user to either enter words or prefixes.

There are also a number of commands one can use to perform other tasks:

\train enters "Training Mode", where the entered words are added to the background data structure.
\prefix enters "Prefix Mode", where the user can enter prefixes to see suggestions.
\h or \help displays the help dialog.
\q or \quit exits the program.

By default, the user is entered into Prefix mode.
Initially, the Autocomplete provider is trained on the text of the Wikipedia page for Cornell University, which can be found at this link: https://en.wikipedia.org/wiki/Cornell_University
