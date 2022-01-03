package in.as.sixtynine.rakku.repositories;

import in.as.sixtynine.rakku.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static in.as.sixtynine.rakku.constants.DBConstants.ENTRY_DB_NAME;

@Repository
@Transactional
public interface EntryRepository extends JpaRepository<Entry, Integer>, JpaSpecificationExecutor<Entry> {

    @Query(value = "SELECT TOP 1 * from " + ENTRY_DB_NAME + "  WHERE type = :type ORDER BY starttime DESC", nativeQuery = true)
    Entry getLastEntry(String type);
}
