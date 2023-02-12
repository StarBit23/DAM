##Programa chat secuencial entre cliente/servidor
@autor santiago rodenas herrรกiz. Para mรณdulo PSP
@version 1
## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


Para ejecutar el Servidor, tenemos que pasarle dos parรกmemtros que son el nombre del servidor y el puerto . Por ejemplo 
> java ServerChat  psp, 3000

Para ejecutar el Clicnete, tenemos que pasarle tres parรกmetros que son el hostname (ip/nombre del host), el puerto del servidor y el nombre del cliente. Por  ejemplo:
> java ClienteChat localhost 3000 santi

Hay que tener en cuenta, que primero se debe de ejecutar el servidor y luego el cliente.
