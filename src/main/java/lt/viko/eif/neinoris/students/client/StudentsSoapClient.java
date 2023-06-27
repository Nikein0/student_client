package lt.viko.eif.neinoris.students.client;

public class StudentsSoapClient {
    public static void main(String... args){

        JettyServer jettyServer = new JettyServer();
        try{
            jettyServer.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //System.out.println(student.getName());
        //System.out.println(student.getSurname());
        //System.out.println(student.getAge());



//xslt


    }
}
