package fr.orsys.bibliotheque.modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-06-26T14:57:12.675+0100")
@StaticMetamodel(Media.class)
public class Media_ {
	public static volatile SingularAttribute<Media, Long> identifiant;
	public static volatile SingularAttribute<Media, String> titre;
	public static volatile SingularAttribute<Media, Date> datePublication;
}
