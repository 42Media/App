# Project Startup

### Quickstart - Developing
Hier kommt eine Beschreibung hin, wie das Programm im Developer-Mode verwendet wird


# Changelogs
#### 2016-04-16
+ create default structure

#### 2016-04-23
+ change default server port to 9000

#### 2016-05-08
+ add new plugins
+ add new settings.gradle, which contains mappings between main app and plugins
+ add plugin dependencies in build.gradle

#### 2016-05-10
+ add master layout

#### 2016-05-12
+ modify master layout

#### 2016-05-22
+ implement spring security plugin
+ create default user admin
+ change main.gsp
+ add VideoAsset class
+ add MusicAsset class
+ create Scaffolding for default CRUD-Functionality
+ add modal functionality

#### 2016-05-24
+ add RestImportController
+ add dependencies for Rest Client

#### 2016-05-25
+ remove RestImportController
+ add restService
+ clean dependencies
+ change package names

#### 2016-05-26
+ debug RestService
+ add LastFMService

#### 2016-05-27
+ add link on name in index view, to show details
+ delete music oder video entries
+ add image domain

#### 2016-06-05
+ add links in the menu for videos and music
+ edit video and music index page

#### 2016-06-08
+ add TestController for LastFMRestAPI

#### 2016-06-10
+ move TestController for LastFMRestAPI and LastFMRestService to External Media

#### 2016-06-11
+ Bug Fixes in the has many relationships
+ layout modifications

#### 2016-06-16
+ Converting LastFM Service to Prepared Map and added to Track

#### 2016-06-19
+ remove bug, which prevented removing old content of modal pages

#### 2016-06-21
+ removed bug, when no rest data available
+ printing artist rest data in track

#### 2016-06-24
+ Limit result to 10 at index page
+ css modifications
+ Edit entries via modal pages
+ select path and upload entries via modalpage
+ insert "Insert Date"
+ show last inserted entry
+ insert filter for music entries
+ insert filter for video entries

#### 2016-06-30
+ music\artist controller
+ music\release controller
+ artist\list action + view
+ artist\show action + view
+ release\list action + view
+ release\show action + view
+ added lastFm\getMetaByAlbum
+ extended lastFM functions to offer image url
+ added default artist.png
+ added default release.png
+ prefer lastFM artwork, if available
+ changed default music view to release\list
+ added navigation from release to releaseArtist\show

#### 2016-07-04
+ change css properties
