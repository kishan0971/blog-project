package Like_Service.LikeRepository;

import Like_Service.LikeEntity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Like findByBlogidAndUserid(long blogid, long userid);

    List<Like> FindByBlogId(long blogid);
}
