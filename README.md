![cover](https://github.com/devrath/NoteApp/blob/main/Assets/banner.png)


<h1 align="center">𝙽𝚘𝚝𝚎𝙰𝚙𝚙</h1>
<p align="center">
<a><img src="https://img.shields.io/badge/Clean-Architecture-orange"></a>
<a><img src="https://img.shields.io/badge/Room-Local--Storage-yellow"></a>
<a><img src="https://img.shields.io/badge/Hilt-Dependency%20Injection-green"></a>
<a><img src="https://img.shields.io/badge/MVVM-Architecture-lightgrey"></a>
<a><img src="https://img.shields.io/badge/Navigation-Jetpack-yellowgreen"></a>
<a><img src="https://img.shields.io/badge/Kotlin-language-green"></a>
</p>

<p align="center">𝙲𝚛𝚎𝚊𝚝𝚒𝚗𝚐 𝚗𝚘𝚝𝚎𝚜 𝚊𝚗𝚍 𝚌𝚊𝚌𝚑𝚒𝚗𝚐 𝚍𝚊𝚝𝚊 𝚠𝚑𝚒𝚌𝚑 𝚜𝚞𝚙𝚙𝚘𝚛𝚝𝚜 𝙲𝚁𝚄𝙳 𝚘𝚙𝚎𝚛𝚊𝚝𝚒𝚘𝚗𝚜 𝚠𝚒𝚝𝚑 𝚊𝚛𝚌𝚑𝚒𝚝𝚎𝚌𝚝𝚞𝚛𝚎 𝚋𝚊𝚜𝚎𝚍 𝚘𝚗 𝙼𝚅𝚅𝙼 𝚊𝚗𝚍 𝚌𝚕𝚎𝚊𝚗 𝚊𝚛𝚌𝚑𝚒𝚝𝚎𝚌𝚝𝚞𝚛𝚎</p>
</br>





## `𝚆𝚑𝚊𝚝 𝚒𝚜 𝚌𝚕𝚎𝚊𝚗 𝚊𝚛𝚌𝚑𝚒𝚝𝚎𝚌𝚝𝚞𝚛𝚎`
* Its a way to organize the project to achieve `maintainability` and `scalability`.
* Having one concern per component -> Meaning each piece of our architecture does only one thing and nothing else. If one component is doing more than one thing, we need to split them 
* It is structured layered dependency. It is not specific to mobile development instead its software development architecture.
* Clean architecture term comes from Uncle bob, He created this methodology for building software products.
* It actually uses existing architectures like `mvvm` and other and additionally uses `use-cases` etc
* It makes your applicaiton scalable majorly involves, how easy it is to replace a layer of application without breaking the other layers.
* A large code base comes with challenge of structuring it which involves how easy it is to extend it, test the functions in it, understand it 

## `𝙰𝚍𝚟𝚊𝚗𝚝𝚊𝚐𝚎𝚜 𝚘𝚏 𝚌𝚕𝚎𝚊𝚗 𝚊𝚛𝚌𝚑𝚒𝚝𝚎𝚌𝚝𝚞𝚛𝚎`
* `Strict architecture` so its not easy to make mistakes.
* `Business logic is encapsulated` so its to use and test.
* `Parallel` development.
* `Highly scalable` so we can grow a small project into a large one without bumping into problems.
* `Easy` to understand and maintain.
* `Testing` is facilitated


## `𝙻𝚊𝚢𝚎𝚛𝚜 𝚘𝚏 𝚌𝚕𝚎𝚊𝚗 𝚊𝚛𝚌𝚑𝚒𝚝𝚎𝚌𝚝𝚞𝚛𝚎`
* `Presentation Layer` contains the UI that we present to the user.
* `Data Layer` contains everything relevant to the data. Things like API, Local-database, Shared-Prefs.
* `Domain Layer` is like a connecting layer, It contains the business rules like filtering a collection and also it contains definitions for repository. It also contains the model classes like entities.

## `More Notes`
**Repository**: 
* Here in the project we have database, We use the database and call the functions of DAO in our repository.
* The repository directly accesses our datasources, wither API or database
* The repository takes these datasources and determine which data has to be forwarded to the corrosponding use-cases.
* Say if you have two data sources(API,Cache), The repository needs to determine, do we load the data fro API or the cache.
* The decesion logic of determing the choosing of data source and determining if there is any errors during this.

**UseCases**:
* Use-cases shouldn't know where the repository gets the data from
* They just get the data and thats it.

**Repository definition in domain layer**:
* This is useful because we can create fake versions of the repository for testing
* We can pass fake repository to use cases for testing so that use cases won't know where the data is coming from
* Say its from a real repository or a local json file, They just get data and do something from it

**Use cases**:
* Contains the business logic
* Makes code very redable, Because essentially the use-case is is something that does one thing.
* We can just know what a class does by just reading the name of the class. Ex: `DeleteNoteUseCase` determines this is used to delete a note.
* They make code very re-usable, because in the end the `view-model` call the use-cases
* If you implement the all the business logic in view-model and say if you need that logic in a different view model its not possible, Using a use-case overcomes this by re-using hte use-case class in a different view-model.





## **`𝙿𝚊𝚌𝚔𝚊𝚐𝚎 𝚂𝚝𝚛𝚞𝚌𝚝𝚞𝚛𝚎 𝚒𝚗 𝚝𝚑𝚎 𝚙𝚛𝚘𝚓𝚎𝚌𝚝`** :package:

    Project Folder                                    
    .
    ├── app                                           
    |   |
    │   ├──> DI   
    |   |
    │   |──> Feature
    |   |    |
    |   |    |──-------------> Data
    |   |    |                  |
    |   |    |                  |──-------------> DataSource
    |   |    |                  |    
    |   |    |                  └──-------------> Repository 
    |   |    |
    |   |    |──-------------> Domain
    |   |    |                  |
    |   |    |                  |──-------------> Model
    |   |    |                  |
    |   |    |                  |──-------------> RepositoryDefinition
    |   |    |                  |
    |   |    |                  |──-------------> UseCase
    |   |    |                  |
    |   |    |                  └──-------------> Util 
    |   |    |
    |   |    └──-------------> Presentation 
    |   |                       |
    |   |                       |──-------------> Screen1
    |   |                       |                 |  
    |   |                       |                 |
    |   |                       |                 └──-------------> Components 
    |   |                       |
    |   |                       └──-------------------------------> MainActivity 
    |   |                       
    |   |──> UI
    |   |    |
    |   |    └──--------------------------------------------------> Theme 
    |   |
    │   └──-------------------------------------------------------> ApplicationClass                
    




## **`𝚂𝚞𝚙𝚙𝚘𝚛𝚝`** ☕
If you feel like support me a coffee for my efforts, I would greatly appreciate it.</br>
<a href="https://www.buymeacoffee.com/devrath" target="_blank"><img src="https://www.buymeacoffee.com/assets/img/custom_images/yellow_img.png" alt="Buy Me A Coffee" style="height: 41px !important;width: 174px !important;box-shadow: 0px 3px 2px 0px rgba(190, 190, 190, 0.5) !important;-webkit-box-shadow: 0px 3px 2px 0px rgba(190, 190, 190, 0.5) !important;" ></a>

## **`𝙲𝚘𝚗𝚝𝚛𝚒𝚋𝚞𝚝𝚎`** 🙋‍♂️
Read [contribution guidelines](CONTRIBUTING.md) for more information regarding contribution.

## **`𝙵𝚎𝚎𝚍𝚋𝚊𝚌𝚔`** ✍️ 
Feature requests are always welcome, [File an issue here](https://github.com/devrath/NoteApp/issues/new).

## **`𝙵𝚒𝚗𝚍 𝚝𝚑𝚒𝚜 𝚙𝚛𝚘𝚓𝚎𝚌𝚝 𝚞𝚜𝚎𝚏𝚞𝚕`** ? ❤️
Support it by clicking the ⭐ button on the upper right of this page. ✌️

## **`𝙻𝚒𝚌𝚎𝚗𝚜𝚎`** ![Licence](https://img.shields.io/github/license/google/docsy) :credit_card:
This project is licensed under the Apache License 2.0 - see the [LICENSE](https://github.com/devrath/NoteApp/blob/main/LICENSE) file for details


<p align="center">
<a><img src="https://forthebadge.com/images/badges/built-for-android.svg"></a>
</p>
