
package sobreviviendo;

import javax.swing.JOptionPane;
import javax.swing.*; 
import java.util.Random;

public class Sobreviviendo {


    public static void main(String[] args) {
  



   
        // Mensaje de bienvenida e introducci�n a la historia
        JOptionPane.showMessageDialog(null, 
            "�Bienvenido a la aventura de sobrevivir al Torbellino!\n" +
            "Hace a�os, un gran torbellino devastador aparec�a en una regi�n remota.\n" +
            "Eres uno de los pocos afortunados en encontrar refugio en un lugar seguro.\n" +
            "Tu objetivo es seleccionar el mejor refugio, recolectar suministros esenciales, y asegurarte de que est�s preparado para enfrentar el torbellino.\n" +
            "Prep�rate, porque tu vida est� en juego.");

        // Inicio de la historia del personaje
        JOptionPane.showMessageDialog(null, 
            "Comienzas en una peque�a aldea que ha sido azotada por una tormenta. El cielo est� oscuro y amenazante.\n" +
            "Sientes el viento cada vez m�s fuerte y el suelo temblar bajo tus pies. La gente corre en todas direcciones, tratando de encontrar un refugio.\n" +
            "Con el coraz�n acelerado, te das cuenta de que necesitas encontrar un lugar seguro r�pidamente.");

        // Selecci�n de refugio
        String[] opcionesRefugio = {
            "Subterraneo",
            "En las Monta�as",
            "En el Bosque"
        };

        int eleccionRefugio = JOptionPane.showOptionDialog(null, 
            "En medio del caos, encuentras tres posibles refugios. Debes decidir r�pidamente d�nde ir.",
            "Selecciona tu refugio",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesRefugio, opcionesRefugio[0]);

        String refugioUsuario = opcionesRefugio[eleccionRefugio];

        // Historia seg�n el refugio seleccionado
        String mensajeRefugio = "Has elegido el refugio: " + refugioUsuario + "\n";
        switch (refugioUsuario) {
            case "Subterraneo":
                mensajeRefugio += "Desciendes a un refugio subterr�neo. La entrada es estrecha, pero una vez dentro, el ambiente es relativamente tranquilo.";
                break;
            case "En las Monta�as":
                mensajeRefugio += "Te diriges hacia las monta�as. El aire es fr�o y cortante, y el camino se vuelve cada vez m�s escarpado.";
                break;
            case "En el Bosque":
                mensajeRefugio += "Te adentras en el bosque, donde los �rboles altos ofrecen algo de refugio del viento.";
                break;
        }
        JOptionPane.showMessageDialog(null, mensajeRefugio);

        // Determina los suministros clave seg�n el refugio
        String suministroClave;
        switch (refugioUsuario) {
            case "Subterraneo":
                suministroClave = "Filtro de agua";
                break;
            case "En las Monta�as":
                suministroClave = "Manta t�rmica";
                break;
            case "En el Bosque":
                suministroClave = "Cobija";
                break;
            default:
                suministroClave = "";
                break;
        }

        // Recolectar suministros
        String[] suministrosDisponibles = {
            "Filtro de agua", "Manta t�rmica", "Cobija", "Linterna", "Radio",
            "Encendedor", "Comida Enlatada", "Botiqu�n B�sico", "Kit de Primeros Auxilios", "Herramientas"
        };

        String[] inventarioUsuario = new String[5];
        int inventarioCount = 0;

        while (inventarioCount < 5) {
            StringBuilder opciones = new StringBuilder("Elige un suministro (1-10) o 0 para terminar:\n");
            for (int i = 0; i < suministrosDisponibles.length; i++) {
                opciones.append(i + 1).append(". ").append(suministrosDisponibles[i]).append("\n");
            }
            opciones.append("0. Terminar");

            String entrada = JOptionPane.showInputDialog(opciones.toString());
            int suministroSeleccionado = Integer.parseInt(entrada);

            if (suministroSeleccionado == 0) {
                break;
            } else if (suministroSeleccionado >= 1 && suministroSeleccionado <= 10) {
                String suministro = suministrosDisponibles[suministroSeleccionado - 1];
                boolean yaRecolectado = false;

                for (int i = 0; i < inventarioCount; i++) {
                    if (inventarioUsuario[i] != null && inventarioUsuario[i].equals(suministro)) {
                        yaRecolectado = true;
                        break;
                    }
                }

                if (!yaRecolectado) {
                    inventarioUsuario[inventarioCount] = suministro;
                    inventarioCount++;
                    JOptionPane.showMessageDialog(null, suministro + " a�adido a tu inventario.");
                } else {
                    JOptionPane.showMessageDialog(null, "Ya has recolectado ese suministro.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "N�mero de suministro inv�lido.");
            }
        }

        // Mensaje si se alcanza el m�ximo de suministros
        if (inventarioCount == 5) {
            JOptionPane.showMessageDialog(null, "Has alcanzado el m�ximo de suministros en tu inventario.");
        }

        // Mostrar suministros recolectados
        StringBuilder suministrosRecolectados = new StringBuilder("Suministros recolectados:\n");
        for (int i = 0; i < inventarioCount; i++) {
            suministrosRecolectados.append("- ").append(inventarioUsuario[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, suministrosRecolectados.toString());

        // Evaluar la seguridad del refugio
        boolean esSeguro = false;
        for (String suministro : inventarioUsuario) {
            if (suministro != null && suministro.equals(suministroClave)) {
                esSeguro = true;
                break;
            }
        }

        // Resultados finales
        String resultado = "El torbellino est� a punto de llegar. Es momento de ver si tu refugio y suministros son suficientes.\n";
        if (esSeguro) {
            resultado += "�Has sobrevivido al Torbellino! El refugio resisti�. �Felicidades, has ganado con el " + suministroClave + "!";
        } else {
            resultado += "El refugio no resisti� el Torbellino. Te falta " + suministroClave + ". Game Over, camarada.";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}







    

