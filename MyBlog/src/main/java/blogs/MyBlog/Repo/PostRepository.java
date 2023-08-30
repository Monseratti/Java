package blogs.MyBlog.Repo;

import blogs.MyBlog.Models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
