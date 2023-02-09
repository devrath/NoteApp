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

<p align="center">𝚃𝚑𝚒𝚜 𝚙𝚛𝚘𝚓𝚎𝚌𝚝 𝚒𝚜 𝚊 𝚜𝚒𝚖𝚙𝚕𝚎 𝚗𝚘𝚝𝚎 𝚊𝚙𝚙𝚕𝚒𝚌𝚊𝚝𝚒𝚘𝚗, 𝚆𝚑𝚎𝚛𝚎 𝚊 𝚞𝚜𝚎𝚛 𝚌𝚊𝚗 𝚌𝚛𝚎𝚊𝚝𝚎 𝚗𝚘𝚝𝚎𝚜, 𝙼𝚘𝚍𝚒𝚏𝚢 𝚝𝚑𝚎 𝚎𝚡𝚒𝚜𝚝𝚒𝚗𝚐 𝚗𝚘𝚝𝚎𝚜 𝚊𝚗𝚍 𝙳𝚎𝚕𝚎𝚝𝚎 𝚎𝚡𝚒𝚜𝚝𝚒𝚗𝚐 𝚗𝚘𝚝𝚎𝚜 𝚜𝚞𝚙𝚙𝚘𝚛𝚝𝚒𝚗𝚐 𝚊𝚕𝚕 𝚝𝚑𝚎 𝙲𝚁𝚄𝙳 𝚘𝚙𝚎𝚛𝚊𝚝𝚒𝚘𝚗𝚜. 𝚃𝚑𝚎 𝚗𝚘𝚝𝚎𝚜 𝚊𝚛𝚎 𝚌𝚊𝚌𝚑𝚎𝚍 𝚘𝚗 𝚝𝚑𝚎 𝚍𝚎𝚟𝚒𝚌𝚎, 𝙱𝚞𝚒𝚕𝚝 𝚘𝚗 𝚊𝚗 𝙼𝚅𝚅𝙼-𝚋𝚊𝚜𝚎𝚍 𝚌𝚕𝚎𝚊𝚗 𝚊𝚛𝚌𝚑𝚒𝚝𝚎𝚌𝚝𝚞𝚛𝚎, 𝚊𝚗𝚍 𝚌𝚘𝚖𝚙𝚘𝚜𝚎 𝚊𝚜 𝚝𝚑𝚎 𝚙𝚛𝚎𝚜𝚎𝚗𝚝𝚊𝚝𝚒𝚘𝚗 𝚕𝚊𝚢𝚎𝚛</p>
</br>

## **`𝙲𝚕𝚎𝚊𝚗 𝚊𝚛𝚌𝚑𝚒𝚝𝚎𝚌𝚝𝚞𝚛𝚎`** 🎈
![architecture](https://github.com/devrath/NoteApp/blob/main/Assets/architecture_note.drawio.png)

## `𝚆𝚑𝚊𝚝 𝚒𝚜 𝚌𝚕𝚎𝚊𝚗 𝚊𝚛𝚌𝚑𝚒𝚝𝚎𝚌𝚝𝚞𝚛𝚎`
* Having one concern per component, Meaning each piece of our architecture does only one thing and nothing else. If one component is doing more than one thing, we need to split them 
* It is structured layered dependency. It is not specific to mobile development instead its software development architecture.
* Clean architecture term comes from Uncle bob, He created this methodology for building software products.
* It actually uses existing architectures like `mvvm` and other and additionally uses `use-cases` etc
* It makes your applicaiton scalable majorly involves, how easy it is to replace a layer of application without breaking the other layers.
* A large code base comes with challenge of structuring it which involves how easy it is to extend it, test the functions in it, understand it 

## `𝙰𝚍𝚟𝚊𝚗𝚝𝚊𝚐𝚎𝚜 𝚘𝚏 𝚌𝚕𝚎𝚊𝚗 𝚊𝚛𝚌𝚑𝚒𝚝𝚎𝚌𝚝𝚞𝚛𝚎`
| **`Advantages`**      | **`How its useful`**                                                                            |
| --------------------- | ----------------------------------------------------------------------------------------------- |
| `Strict architecture` | Because of how the layers of code are organized it is not easy to make mistakes                 |
| `Encapsulation`       | Each layer is organized into its own part having its own responsibility                         |
| `Parallel development`| If we have each feature in module wise each of the modules are built parallely                  |
| `Highly scalable`     | Once organized properly, we can grow a small project into large one without bumping to problems |
| `Simple and easy`     | Due to single responsibility its way easier to understand each snipped of code on what it does  |
| `Testing`             | Since all the layers are decoupled, we can write unit tests on them easily                      |

## `𝚂𝙾𝙻𝙸𝙳 - 𝚙𝚛𝚒𝚗𝚌𝚒𝚙𝚕𝚎𝚜`

<details>
<summary>𝚂𝚒𝚗𝚐𝚕𝚎 𝚛𝚎𝚜𝚙𝚘𝚗𝚜𝚒𝚋𝚒𝚕𝚒𝚝𝚢 𝚙𝚛𝚒𝚗𝚌𝚒𝚙𝚕𝚎</summary>
    
* A class should have only one job.</br>
* A class should have only one reason to change.</br>
* If the class has two reasons to change, Then the class has to be split up into two components.</br>

</details>

<details>
<summary>𝙾𝚙𝚎𝚗 𝙲𝚕𝚘𝚜𝚎𝚍 𝚙𝚛𝚒𝚗𝚌𝚒𝚙𝚕𝚎</summary>
    
* It should be open for extension, but closed for modification.</br>
* If new functionality needs to be added, it should be added as an extension of the class.</br>
* This allows us to abstract the stable functionality.</br>
* If functionality is working and stable and we add a new feature on top of the existing feature for it. Now we will have stable functionality always working.</br>
* Thus the volatile functionality will be in the extended classes and the stable functionality in the extended classes.</br>
</details>

<details>

<summary>𝙻𝚒𝚜𝚔𝚘𝚟 𝚜𝚞𝚋𝚜𝚝𝚒𝚝𝚞𝚝𝚒𝚘𝚗 𝚙𝚛𝚒𝚗𝚌𝚒𝚙𝚕𝚎</summary>
    
* Lower level classes can be substituted without affecting higher levels.</br>
* This is achieved using abstract classes and interfaces.</br>

</details>

<summary>𝙸𝚗𝚝𝚎𝚛𝚏𝚊𝚌𝚎 𝚜𝚎𝚐𝚛𝚎𝚐𝚊𝚝𝚒𝚘𝚗 𝚙𝚛𝚒𝚗𝚌𝚒𝚙𝚕𝚎</summary>
    
* We use an interface to advertise the functionality.</br>
* Many specific interfaces are better than a generic interface.</br>
* Interface just exposes the methods the dependent classes needed and nothing else.</br>

</details>

<summary>𝙳𝚎𝚙𝚎𝚗𝚍𝚎𝚗𝚌𝚢 𝚒𝚗𝚟𝚎𝚛𝚜𝚒𝚘𝚗 𝚙𝚛𝚒𝚗𝚌𝚒𝚙𝚕𝚎</summary>
    
* Concrete classes depend on abstract classes and not the other way around.</br>
* Volatile and stable functionalities are encapsulated, having the dependency relationship between the two.</br>
* Framework-specific functionality depends on business logic with a dependency between them.</br>

</details>


## `𝙻𝚊𝚢𝚎𝚛𝚜 𝚘𝚏 𝚙𝚛𝚘𝚓𝚎𝚌𝚝 𝚊𝚛𝚌𝚑𝚒𝚝𝚎𝚌𝚝𝚞𝚛𝚎`
![architecture-layers](https://github.com/devrath/NoteApp/blob/main/Assets/diagram_Notes.drawio.png)


## `𝙼𝚘𝚛𝚎 𝙽𝚘𝚝𝚎𝚜`

<details>
<summary>𝚁𝚎𝚙𝚘𝚜𝚒𝚝𝚘𝚛𝚢:</summary>
    
* Here in the project we have database, We use the database and call the functions of DAO in our repository.</br>
* The repository directly accesses our datasources, wither API or database.</br>
* The repository takes these datasources and determine which data has to be forwarded to the corrosponding use-cases.</br>
* Say if you have two data sources(API,Cache), The repository needs to determine, do we load the data fro API or the cache.</br>
* The decesion logic of determing the choosing of data source and determining if there is any errors during this.</br>

</details>


<details>
<summary>𝚄𝚜𝚎𝙲𝚊𝚜𝚎𝚜:</summary>
    
* Use-cases shouldn't know where the repository gets the data from.</br>
* They just get the data and thats it.</br>
* Contains the business logic.</br>
* Makes code very redable, Because essentially the use-case is is something that does one thing.</br>
* We can just know what a class does by just reading the name of the class. Ex: `DeleteNoteUseCase` determines this is used to delete a note.</br>
* They make code very re-usable, because in the end the `view-model` call the use-cases.</br>
* If you implement the all the business logic in view-model and say if you need that logic in a different view model its not possible, Using a use-case overcomes this by re-using hte use-case class in a different view-model.</br>

</details>


<details>
<summary>𝚁𝚎𝚙𝚘𝚜𝚒𝚝𝚘𝚛𝚢 𝚍𝚎𝚏𝚒𝚗𝚒𝚝𝚒𝚘𝚗 𝚒𝚗 𝚝𝚑𝚎 𝚍𝚘𝚖𝚊𝚒𝚗 𝚕𝚊𝚢𝚎𝚛:</summary>
    
* This is useful because we can create fake versions of the repository for testing</br>
* We can pass fake repository to use cases for testing so that use cases won't know where the data is coming from</br>
* Say its from a real repository or a local json file, They just get data and do something from it</br>

</details>


<details>
<summary>𝚅𝚒𝚎𝚠-𝙼𝚘𝚍𝚎𝚕:</summary>
    
* When we just use a `mvvm` architecture, we have all the business logic in the `view-model`</br>
* But when we use `clean-architecture` in combination with `mvvm`, the business logic is lifted to `use-case` layer.</br>
* So the view model puts some inputs to a use-case and performs some computation based on the input and gets the result and delegates the resut as a state to the presentation(UI) layer.</br>

</details>




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
    

## `Modes`

<div align="center">

### `𝙳𝚊𝚛𝚔 𝙼𝚘𝚍𝚎`🌚
| **`𝙽𝚘𝚝𝚎𝚜 𝙻𝚒𝚜𝚝`** | **`𝚅𝚒𝚎𝚠 𝙽𝚘𝚝𝚎`** | **`𝙴𝚍𝚒𝚝 𝚗𝚘𝚝𝚎`** |
| ---------------- | --------------- | --------------- |
| <img src="https://github.com/devrath/NoteApp/blob/main/Assets/outputs/dark_notes.jpg" width="160" height="330"/> | <img src="https://github.com/devrath/NoteApp/blob/main/Assets/outputs/dark_note.jpg" width="160" height="330"/> | <img src="https://github.com/devrath/NoteApp/blob/main/Assets/outputs/dark_notes_edit.jpg" width="160" height="330"/> |

</div>


<div align="center">

### `𝙻𝚒𝚐𝚑𝚝 𝙼𝚘𝚍𝚎`🌞
| **`𝙽𝚘𝚝𝚎𝚜 𝙻𝚒𝚜𝚝`** | **`𝚅𝚒𝚎𝚠 𝙽𝚘𝚝𝚎`** | **`𝙴𝚍𝚒𝚝 𝚗𝚘𝚝𝚎`** |
| ---------------- | --------------- | --------------- |
| <img src="https://github.com/devrath/NoteApp/blob/main/Assets/outputs/light_notes.jpg" width="160" height="330"/> | <img src="https://github.com/devrath/NoteApp/blob/main/Assets/outputs/light_note.jpg" width="160" height="330"/> | <img src="https://github.com/devrath/NoteApp/blob/main/Assets/outputs/light_notes_edit.jpg" width="160" height="330"/> |

</div>

## **`𝙳𝚎𝚖𝚘`** 🗼
<div align="center">
<video align="center" height="500" width="600" src="https://user-images.githubusercontent.com/1456191/217759442-9293c262-a353-4c9c-af69-74e84b26443c.mp4"  alt="dev_logo"/>
</div>

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
