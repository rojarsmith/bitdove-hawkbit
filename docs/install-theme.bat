rem
rem Copyright (c) 2018 Bosch Software Innovations GmbH and others.
rem
rem All rights reserved. This program and the accompanying materials
rem are made available under the terms of the Eclipse Public License v1.0
rem which accompanies this distribution, and is available at
rem http://www.eclipse.org/legal/epl-v10.html
rem

rem This script checks if 'hugo' is installed. Afterwards, the Hugo theme is downloaded.

@echo off

hugo "version"
IF %errorlevel%== 1 (
  echo "[ERROR] Please install Hugo first before proceeding."
  exit "1"
)
echo "[INFO] "
echo "[INFO] Install Hugo Theme"
SET HUGO_THEMES=themes\hugo-material-docs
IF not exist  %HUGO_THEMES%\ (
  git "submodule" "add" "--force" "https://github.com/digitalcraftsman/hugo-material-docs.git" "%HUGO_THEMES%"
  echo "[INFO] ... done"
) ELSE (
  echo "[INFO] ... theme already installed in: %HUGO_THEMES%"
)
echo "[INFO] "
echo "[INFO] Launch the documentation locally by running 'mvn site' (or 'hugo server' in the docs directory),"
echo "[INFO] and browse to 'http://localhost:1313/doc/bitdove/'. "
