package cn.edu.guet.demo2.Controller;


import cn.edu.guet.demo2.dto.NewsCreateDTO;
import cn.edu.guet.demo2.service.NewsService;
import cn.edu.guet.demo2.util.PageRequest;
import cn.edu.guet.demo2.util.Result;
import cn.edu.guet.demo2.vo.NewsVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @PostMapping
    public Result<NewsVO> createNews(@RequestBody NewsCreateDTO newsCreateDTO){
        log.info("新闻标题：{}",newsCreateDTO.getTitle());
        log.info("栏目分类：{}}",newsCreateDTO.getCategory());
        return Result.success("新闻已提交审核",newsService.createNews(newsCreateDTO));
    }
    @PostMapping("/page")
    public Result<IPage<NewsVO>> getNewsPage(@RequestBody PageRequest pageRequest) {
        return Result.success(newsService.getNewsPage(pageRequest));
    }
}
