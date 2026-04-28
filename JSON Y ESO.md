# 📝 Chuletario: Excepciones, Ficheros y JSON en Java (1º DAW)

## 1. Gestión de Excepciones

### Bloque estándar (El "paraguas")
Si usas varios `catch`, pon siempre el más específico arriba y el más genérico (`Exception`) abajo.
```java
try {
    // Código que puede petar
} catch (ArithmeticException e) {
    System.out.println("Error matemático: " + e.getMessage());
} catch (Exception e) {
    System.out.println("Error genérico: " + e.toString());
} finally {
    // Se ejecuta SIEMPRE (útil para cerrar Scanner o Ficheros si no usas try-with-resources)
}
```

### Throw vs Throws
- **`throws` (en la firma):** "Aviso que este método puede lanzar un error, que lo gestione quien lo llame".
- **`throw` (en el cuerpo):** "Lanzo yo el error manualmente ahora mismo".
```java
public void validarEdad(int edad) throws EdadInvalidaException {
    if (edad < 0) throw new EdadInvalidaException("No puede ser negativa");
}
```

---

## 2. Archivos de Texto (Línea a línea)

### Lectura (BufferedReader) - *El más rápido*
```java
try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
    String linea;
    while ((linea = br.readLine()) != null) {
        System.out.println(linea); // Procesar la línea
    }
} catch (IOException e) { e.printStackTrace(); }
```

### Escritura (BufferedWriter)
- `new FileWriter(path)` -> Sobrescribe.
- `new FileWriter(path, true)` -> **Modo Append** (añade al final).
```java
try (BufferedWriter bw = new BufferedWriter(new FileWriter("notas.txt", true))) {
    bw.write("Nueva línea de texto");
    bw.newLine(); // Salto de línea automático
} catch (IOException e) { e.printStackTrace(); }
```

---

## 3. Archivos Binarios (Datos y Objetos)

### Datos Primitivos (`DataOutputStream` / `DataInputStream`)
Útil para guardar solo números o cadenas sueltas. **Importante:** Leer en el mismo orden que se escribió.
```java
// Escribir
dos.writeInt(25);
dos.writeDouble(10.5);
// Leer
int n = dis.readInt();
double d = dis.readDouble();
```

### Serialización de Objetos (`ObjectStream`)
Para guardar objetos enteros o colecciones (`ArrayList`, `HashMap`) de golpe.
1. **Obligatorio:** La clase debe tener `implements Serializable`.
2. **Recomendado:** Añadir `private static final long serialVersionUID = 1L;`.

```java
// GUARDAR (Serializar)
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("backup.dat"))) {
    oos.writeObject(miListaDeObjetos); // Puede ser un ArrayList entero
}

// CARGAR (Deserializar)
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("backup.dat"))) {
    miLista = (ArrayList<Objeto>) ois.readObject(); // Necesita Casting
}
```

---

## 4. Archivos JSON (Librería Jackson)

### ObjectMapper (El cerebro)
Es la herramienta principal para convertir entre Java y JSON.
```java
ObjectMapper mapper = new ObjectMapper();

// 1. Guardar Objeto o Lista a JSON
mapper.writeValue(new File("datos.json"), miObjeto);

// 2. Leer Objeto simple
Persona p = mapper.readValue(new File("persona.json"), Persona.class);

// 3. Leer Lista compleja (OJO a esto en el examen)
List<Persona> lista = mapper.readValue(new File("lista.json"), new TypeReference<List<Persona>>(){});
```

---

## 5. Patrones y "Trucos" de Examen

### El patrón "Carga de CSV" (`split`)
Muy común para leer archivos de texto donde los datos vienen separados por puntos y coma o dos puntos.
```java
String linea = "12345678Z:Pepe:Perez";
String[] partes = linea.split(":"); 
// partes[0] es DNI, partes[1] es Nombre...
Alumno a = new Alumno(partes[0], partes[1], partes[2]);
```

### Estructura de Gestor Pro (Ficheros + Mapas)
Como en el ejercicio de Videojuegos o Alumnos:
```java
public class Gestor {
    private Map<String, List<Videojuego>> mapa; // Categoría -> Lista de items

    // Para añadir:
    public void añadir(Videojuego v) {
        mapa.putIfAbsent(v.getGenero(), new ArrayList<>()); // Crea la lista si no existe
        mapa.get(v.getGenero()).add(v);
    }

    // Para buscar por un atributo que no es la clave (ID):
    public Videojuego buscarPorId(String id) {
        for (List<Videojuego> lista : mapa.values()) { // Recorre todas las listas del mapa
            for (Videojuego v : lista) {
                if (v.getId().equals(id)) return v;
            }
        }
        return null;
    }
}
```

### Comprobaciones de Archivo (Clase `File`)
Antes de leer, evita el error `FileNotFoundException`.
```java
File f = new File("datos.bin");
if (f.exists() && f.isFile()) {
    // Proceder a leer
} else {
    f.createNewFile(); // Crea el archivo vacío si no existe
}
```

### Resumen de "Cierres"
- Si usas `try (Recurso r = ...)` (try-with-resources), **NO** hace falta cerrar manualmente.
- Si usas un `try` normal, **DEBES** cerrar en el `finally`: `if (br != null) br.close();`.

### Manejo del Buffer de Scanner (Recordatorio importante)
Si en el examen te piden un menú que lee datos:
```java
int opcion = sc.nextInt();
sc.nextLine(); // LIMPIAR SIEMPRE después de un número si luego vas a leer un String
String nombre = sc.nextLine();
```

---
**¿Qué repasar más?**
1. Saber cuándo usar `ArrayList` (orden) vs `HashSet` (sin duplicados) vs `HashMap` (búsqueda rápida).
2. Practicar el **Casting** al leer de archivos binarios de objetos.
3. El uso de `instanceof` si en un archivo guardas una lista de una clase padre pero quieres acceder a métodos del hijo.