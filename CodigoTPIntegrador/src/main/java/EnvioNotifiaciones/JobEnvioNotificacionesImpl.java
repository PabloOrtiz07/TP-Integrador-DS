package EnvioNotifiaciones;

import Dominio.Entidades.Contacto;
import Dominio.Entidades.RepositorioOrganizaciones;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;

public class JobEnvioNotificacionesImpl implements Job {

    @Override
    public void execute(JobExecutionContext jobContext) throws JobExecutionException {
        JobDetail jobDetail = jobContext.getJobDetail();

        System.out.println("--------------------------------------------------------------------");
        System.out.println("EJECUTANDO JOB " + jobDetail.getKey());
        System.out.println("Inicio: " + jobContext.getFireTime());
        System.out.println("Proxima ejecucion: " + jobContext.getNextFireTime());

        RepositorioOrganizaciones repo = RepositorioOrganizaciones.getInstance();
        List<Contacto> contactos = repo.getOrganizaciones().stream().flatMap(organizacion -> organizacion.getContactos().stream()).collect(Collectors.toList());
        String emailSeparadoPorComa = contactos.stream().map(contacto -> contacto.getEmail()).collect(Collectors.joining(","));
        String telefonosSeparadosPorComa= contactos.stream().map(Contacto::getTelefono).collect(Collectors.joining(","));

        EmailSender emailSender = new EmailSender();
        emailSender.send("dds2022grupo8@gmail.com", emailSeparadoPorComa, "Recomendaciones:", "LINK A LAS RECOMENDACIONES: https://www.frba.utn.edu.ar/");
        System.out.println("Emails enviados con exito a las siguientes cuentas: " + emailSeparadoPorComa);
        WhatsappSender whatsappSender = new WhatsappSender();
        whatsappSender.enviar(telefonosSeparadosPorComa);
        System.out.println("--------------------------------------------------------------------");

    }
}
