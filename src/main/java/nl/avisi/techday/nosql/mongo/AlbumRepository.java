package nl.avisi.techday.nosql.mongo;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;


/**
 * Simple repository interface to manage {@link Album} instances.
 * 
 * @author Oliver Gierke
 */
public interface AlbumRepository extends CrudRepository<Album, ObjectId> {

	/**
	 * Queries {@link Album}s by filtering on {@code tracks.name}.
	 * 
	 * @param name
	 * @return
	 */
	List<Album> findByTracksName(String name);


	/**
	 * Returns all {@link Album} with a {@link Track} title like the given
	 * parameter.
	 * 
	 * @param name
	 * @return
	 */
	List<Album> findByTracksNameLike(String name);


	/**
	 * Returns all {@link Album}s with a {@link Track} having a rating greater
	 * than the given one.
	 * 
	 * @param rating
	 * @return
	 */
	List<Album> findByTracksRatingGreaterThan(Stars rating);
}
