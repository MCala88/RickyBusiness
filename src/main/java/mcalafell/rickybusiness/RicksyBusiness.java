package mcalafell.rickybusiness;


public class RicksyBusiness {

	public static void main(String[] args) {

        /**
         * Crea una tarjeta de cr�dito para Abradolph.
         * Como es una AndromedanExpress
         * el cr�dito inicial es de 3000 EZIS
         */
		
		
        CreditCard abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");
        
        System.out.println("\n" + "Tarjeta de Abradolph" + "\n" + 
                                  "===================="        );
        System.out.println(abradolph);

        /**
         * Construye el componente de reserva de Ovnis.
         * Recibe el objeto tarjeta de cr�dito del invitado/a
         * en el m�todo dispatch(card)
         * y realiza un cargo a la tarjeta.
         * Si hay saldo suficiente se reserva un UberOvni
         * de los que est�n libres.
         * El coste del ovni es de 500 EZIs.
         */

        UfosPark ufosPark = new UfosPark();

        // Da de alta en la flota de ovnis 2 UFOS.

        String[] ufosID = { "unx", "dox" };
		for (String ovni : ufosID) {
			ufosPark.add(ovni);
        }

        
        // Procesamos el pago y reserva de ovni de Abradolph
        ufosPark.dispatch(abradolph);

        // Mostramos el ID del ovni asignado a Abradolph
        System.out.println("\nOvni de Abradolph\n" + 
                             "=================");
        System.out.println(ufosPark.getUfoOf(abradolph.number()));
       
        // Mostramos el credito de la tarjeta de Abradolph
        System.out.println("Credito de Abradolph: " + abradolph.credit());

        // Abradolph quiere reservar otro ovni.
        // El sistema detecta que ya tiene uno 
        // e ignora la petici�n.

        System.out.println("\nAbradolph quiere otro ovni\n" + 
                             "==========================");
        ufosPark.dispatch(abradolph);
        System.out.println("Su credito no ha cambiado: " + abradolph.credit());
        System.out.println("Ovni de Abradolph: " + ufosPark.getUfoOf(abradolph.number()));

        // A GearHead le vac�a la tarjeta el alien "C�mara Lenta" 
        // mientras le daba la chapa, justo antes de pagar el ovni.
        // Intenta reservarlo y el componente de reserva de ovnis
        // no le asigna ninguno.

        System.out.println("\nLLega GearHead!\n" + 
                             "===============");
        CreditCard gearHead = new CreditCard("Gearhead", "8888888888888888");

        gearHead.pay(3000); // le vac�an la cartera

        
         /* ufosPark.dispatch(gearHead);*/
        System.out.println("Su credito es cero: " + gearHead.credit());
        System.out.println("No puede reservar ovni: " + ufosPark.getUfoOf(gearHead.number()));
        
        // Squanchy deja su ovni reservado
        // antes de irse a squanchear

        System.out.println("\nLLega Squanchy!\n" + 
                             "==============");
        CreditCard squanchy = new CreditCard("Squanchy", "4444444444444444");
        ufosPark.dispatch(squanchy);
        System.out.println("Su credito es: " + squanchy.credit());
        System.out.println("Su ovni es: " + ufosPark.getUfoOf(squanchy.number()));

        // Morty quiere un ovni para huir de la fiesta
        // pero ya no queda ninguno disponible

        System.out.println("\nAlgun ovni para Morty?\n" + 
                             "======================");
        CreditCard morty = new CreditCard("Morty", "0000000000000000");
        ufosPark.dispatch(morty);
        System.out.println("Su credito no ha cambiado: " + morty.credit());
        System.out.println("No hay ovni Morty: " + ufosPark.getUfoOf(morty.number()));

        // Metemos un ovni m�s en la flota de ovnis
        // y mostramos la flota por consola

        System.out.println("\nFlota de ovnis\n" + 
                             "==============");
        ufosPark.add("trex");
        System.out.println(ufosPark);


        /**
         * Construye el dispensador de packs de bienvenida.
         * Indica el numero de unidades y el coste de cada
         * uno de ellos, que es de 50 EZIs
         */

        CrystalExpender packExpender = new CrystalExpender(3, 50);

        // Muestra el total de packs y su precio unidad
        System.out.println("\nPacks\n" + 
                             "=====");
        System.out.println(packExpender);

        // Abradolph compra su pack de bienvenida
        packExpender.dispatch(abradolph);

        System.out.println("\nAbradolph compra su pack\n" + 
                             "========================");
        System.out.println("Packs\n" + packExpender);
        System.out.println("Credito de Abradolph: " + abradolph.credit());

        // El pobre GerHead no tiene cr�dito para comprar su pack
        System.out.println("\nGearHead sin credito para su pack\n" + 
                             "=================================");
        packExpender.dispatch(gearHead);
        System.out.println("Packs\n" + packExpender);
        System.out.println("Credito de GearHead: " + gearHead.credit());


        /**
         * Vamos a automatizar ahora ambas tareas, de modo que
         * cuando llega un invitado/a se le asiga un ovni
         * y un pack y se realiza el cargo a la tarjeta.
         * 
         * Para ello, crea el componente receptivo
         * y registra (a�ade) los componentes UfosPark
         * y CrystalDispatcher al receptivo
         */

        Receptivo receptivo = new Receptivo();
        receptivo.registra(packExpender);
        receptivo.registra(ufosPark);

        // Implementa el metodo receptivo.dispatch()
        // para que invoque a UfosPark.dispatch()
        // y a CrystalExpender.dispatch()

        // Squanchy reserva ovni (ya tiene) y pack

        System.out.println("\nLLega Squanchy!\n" + 
                             "===============");
        receptivo.dispatch(squanchy);
        mostrarReserva(squanchy, packExpender, ufosPark);

        // Gearhead reserva ovni y pack.
        // No tiene cr�dito.

        System.out.println("\nLLega GearHead!\n" + 
                             "===============");
        gearHead.pay(3000); // no tiene cr�dito
        receptivo.dispatch(gearHead);
        mostrarReserva(gearHead, packExpender, ufosPark);

        // Birdpearson es recibido en la fiesta

        System.out.println("\nLLega Birdpearson!\n" + 
                             "==================");
        CreditCard birdpearson = new CreditCard("Birdpearson", "1111111111111111");
        receptivo.dispatch(birdpearson);
        mostrarReserva(birdpearson, packExpender, ufosPark);

        // Morty intenta reserver un ovni y un pack pero no quedan

        System.out.println("\nMorty quiere pack y ovni pero no quedan :(\n" + 
                             "==========================================");
        morty = new CreditCard("Morty", "0000000000000000");
        receptivo.dispatch(morty);
        mostrarReserva(morty, packExpender, ufosPark);
        

        /**
         * A por el 10!! 
         * Wubba lubba dub dub!!
         * 
         * A�ade otra tarea al receptivo,
         * de modo que 5 invitados:
         * abradolph, squanchy, morty, gearHead, birdpearson
         * encarguen un RickMen� junto 
         * al ovni y al pack de bienvenida.
         * Hay 100 RickMen�s y su precio es de 10 EZIs.
         * Muestra el total de pedidos y la lista de
         * invitados/as que han hecho un pedido.
         */

         // tu c�digo aqu�
    }

    private static void mostrarReserva(CreditCard card, CrystalExpender expender, UfosPark ufos) {
        System.out.println(card);
        System.out.println("Packs: " + expender.stock());
        System.out.println("Ovni: " + ufos.getUfoOf(card.number()));
    }


	




	}


