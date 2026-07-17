# LlanquihueTour EFT

Aplicación de consola desarrollada en Java para gestionar información básica de la agencia de turismo Llanquihue Tour. El sistema carga personas y tours desde archivos de texto, valida los datos, relaciona cada servicio con su guía y permite administrar reservas en memoria.

## Funcionalidades

- Carga de clientes, guías turísticos y colaboradores externos desde archivos de texto.
- Validación del formato del RUT, teléfono, dirección y campos numéricos.
- Carga de rutas gastronómicas, paseos lacustres y excursiones culturales.
- Asociación de cada servicio turístico con un guía mediante su código.
- Búsqueda de clientes por RUT, guías por código y servicios por código.
- Gestión de reservas únicas mediante un `HashMap`.
- Uso de herencia, polimorfismo, colecciones genéricas, excepciones personalizadas y la interfaz `Registrable`.

## Estructura del proyecto

```text
LlanquihueTour_EFT/
├── Resources/
│   ├── Clientes.txt
│   ├── Guias-Colaboradores.txt
│   └── Tours.txt
├── src/
│   ├── data/
│   │   ├── GestorArchivos.java
│   │   ├── GestorPersonas.java
│   │   ├── GestorReservas.java
│   │   └── GestorServicios.java
│   ├── model/
│   │   ├── Persona/
│   │   ├── ServicioTuristico/
│   │   ├── Registrable.java
│   │   └── Reserva.java
│   ├── ui/
│   │   └── Main.java
│   └── utils/
│       ├── RutInvalido.java
│       └── TelefonoInvalido.java
└── README.md
```

## Diseño del sistema

### Personas

`Persona` es la clase abstracta que reúne nombre, RUT, dirección, correo y teléfono. Sus subclases son:

- `Cliente`: representa a quien contrata un servicio.
- `GuiaTuristico`: añade el código utilizado para asignar tours.
- `ColaboradorExterno`: añade el tipo de colaboración que presta a la agencia.

`Rut` y `Direccion` son objetos de apoyo que encapsulan y validan esos datos.

### Servicios turísticos

`ServicioTuristico` contiene los datos comunes de los tours: código, nombre, destino, precio, duración y guía responsable. Sus especializaciones son:

- `RutaGastronomica`: incorpora el número de paradas.
- `PaseoLacustre`: incorpora el tipo de embarcación.
- `ExcursionCultural`: incorpora el lugar turístico.

### Reservas

`Reserva` relaciona un cliente con un servicio, una cantidad de personas y uno de los estados permitidos: `PENDIENTE`, `CONFIRMADA` o `CANCELADA`. `GestorReservas` utiliza un `Map<String, Reserva>` para impedir códigos duplicados y buscar reservas por código.

### Interfaz común

`Registrable` declara `mostrarInformacion()`. Clientes, guías, colaboradores, servicios y reservas implementan este contrato para entregar su información como texto.

## Archivos de entrada

Los archivos deben permanecer dentro de `Resources` y usar punto y coma como separador.

### `Clientes.txt`

```text
tipo;nombre;rut;calle;numero;region;correo;telefono
```

### `Guias-Colaboradores.txt`

```text
tipo;nombre;rut;calle;numero;region;correo;telefono;atributoParticular
```

Para un guía, el último campo corresponde a su código. Para un colaborador, corresponde al tipo de colaboración.

### `Tours.txt`

```text
codigo;nombre;destino;precio;duracionDias;codigoGuia;nombreGuia;atributoParticular
```

Los códigos reconocidos son:

- `01GA`: ruta gastronómica; el atributo particular es el número de paradas.
- `02LA`: paseo lacustre; el atributo particular es el tipo de embarcación.
- `03CU`: excursión cultural; el atributo particular es el lugar turístico.

## Validaciones principales

- RUT sin puntos, con guion y entre siete y ocho dígitos más dígito verificador.
- Teléfono con el formato `+56912345678`.
- Número de dirección, precio, duración, cantidad de personas y paradas mayores que cero.
- Guía existente antes de crear un servicio turístico.
- Campos obligatorios y cantidad de campos por línea.
- Código único y estado válido para cada reserva.

Las líneas inválidas se omiten y el motivo se informa por consola.

## Requisitos

- JDK 8 o superior.
- IntelliJ IDEA o una terminal con `javac` y `java` disponibles.

## Ejecución en IntelliJ IDEA

1. Abrir la carpeta `LlanquihueTour_EFT` en IntelliJ IDEA.
2. Configurar un JDK para el proyecto y confirmar que `src` esté marcada como carpeta de código fuente.
3. Mantener la carpeta `Resources` en la raíz del proyecto.
4. Ejecutar el método `main` de `src/ui/Main.java`.

La aplicación debe ejecutarse con la raíz del proyecto como directorio de trabajo para encontrar las rutas relativas de los archivos.

## Resultado actual de la demostración

`Main` carga los archivos, busca el cliente con RUT `98765432-1`, busca el guía `GUI-001`, carga los tours válidos y muestra los servicios encontrados por consola.

## Autora

Nicole Ortega
