package Like_Service.LikeRepository;

import Like_Service.LikeEntity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Like findByBlogidAndUserid(long blogid, long userid);
}
