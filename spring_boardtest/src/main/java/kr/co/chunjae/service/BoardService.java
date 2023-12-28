package kr.co.chunjae.service;

import kr.co.chunjae.dto.BoardDTO;
import kr.co.chunjae.dto.PageDTO;
import kr.co.chunjae.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public int save(BoardDTO boardDTO) {
        return boardRepository.save(boardDTO);
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public BoardDTO findById(Long id){
        return boardRepository.findById(id);
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    int pageLimit = 3;
    int blockLimit = 5;
    public List<BoardDTO> pageList(int page) {


        int pagingStart = (page-1) * pageLimit;
        Map<String, Integer> pagingParams = new HashMap<>();
        pagingParams.put("start", pagingStart);
        pagingParams.put("limit", pageLimit);
        List<BoardDTO> pagingList = boardRepository.pagingList(pagingParams);
        return pagingList;
    }

    public PageDTO pagingParam(int page) {

        int boardCount = boardRepository.boardCount();

        int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));

        int startPage = (((int)(Math.ceil((double) page/blockLimit))) - 1) * blockLimit + 1;

        int endPage = startPage + blockLimit - 1;

        if(endPage > maxPage) {
            endPage = maxPage;
        }

        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setStartPage(startPage);
        pageDTO.setEndPage(endPage);
        return pageDTO;
    }

}
