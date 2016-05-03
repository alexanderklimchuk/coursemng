/**
 * 
 */
package by.kochergin.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.kochergin.app.domain.Discountcard;

/**
 * @author Aliaksandr
 *
 */
@Repository
public interface IDiscountcardDao extends CrudRepository<Discountcard, Integer> {

}
