Git step by step 

Check if Git is installed. If not, download and install it from https://git-scm.com/downloads. During installation, make sure to select the option to add Git to your system PATH.

If Git is already installed but you get the error, add Git's installation directory to your PATH manually:

Open Start and search for "Environment Variables" and select "Edit the system environment variables".

In the System Properties window, click on "Environment Variables".

Under "System variables", find and select "Path", then click "Edit".

Click "New" and add Git's binary paths, typically:

text
C:\Program Files\Git\bin
C:\Program Files\Git\cmd
Click OK on all dialogs to save changes.

Close and reopen your command prompt or terminal for the changes to take effect.

Type git --version in the command prompt to verify Git is recognized.

git command- 
git status          # Check files
git add .           # Stage all
git status          # Verify staged
git commit -m "Initial Java code commit"
git remote add origin https://github.com/PriyaBanerjee/JavaCode.git
git push -u origin master

To undo the initialization (if you ran git init in the wrong place):

text
rmdir /s .git

