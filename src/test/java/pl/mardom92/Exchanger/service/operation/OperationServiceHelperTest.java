package pl.mardom92.Exchanger.service.operation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mardom92.Exchanger.model.entity.OperationEntity;
import pl.mardom92.Exchanger.model.exception.operation.OperationException;
import pl.mardom92.Exchanger.repository.OperationRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationServiceHelperTest {

    private OperationServiceHelper operationServiceHelper;
    private OperationRepository operationRepository;

    @BeforeEach
    void initializeServiceHelper() {
        operationServiceHelper = new OperationServiceHelper(operationRepository);
    }

    @Test
    void shouldThrowExceptionWhenCheckSizeOfListAndOperationIsEmpty() {

        //given
        List<OperationEntity> operations = new ArrayList<>();

        //when
        try {
            operationServiceHelper.checkSizeOfList(operations);
        } catch (OperationException exception) {

            //then
            assertEquals("List of operations is empty.", exception.getOperationError().getMessage());
        }
    }

    @Test
    void shouldReturnSizeWhenCheckSizeOfListAndOperationIsNotEmpty() {

        //given
        List<OperationEntity> operations = new ArrayList<>();
        operations.add(new OperationEntity());

        //when
        int size = operationServiceHelper.checkSizeOfList(operations);

        //then
        assertEquals(1, size);
    }

    @Test
    void shouldThrowExceptionWhenCheckPageNumberIsLessThanOne() {

        //given
        int pageNumber = -1;

        //when
        try {
            operationServiceHelper.checkPageNumber(pageNumber);
        } catch (OperationException exception) {

            //then
            assertEquals("Wrong page number value.", exception.getOperationError().getMessage());
        }
    }

    @Test
    void shouldReturnPageWhenCheckPageNumber() {

        //given
        int pageNumber = 2;

        //when
        int page = operationServiceHelper.checkPageNumber(pageNumber);

        //then
        assertEquals(2, page);
    }

    @Test
    void shouldThrowExceptionWhenCheckSizeOnPageAndSizeOnPageIsGreaterThanMaxSize() {

        //given
        int pageNumber = 5;
        int maxSize = 3;

        //when
        try {
            operationServiceHelper.checkSizeOnPage(pageNumber, maxSize);
        } catch (OperationException exception) {

            //then
            assertEquals("Parameter size on page is to great.", exception.getOperationError().getMessage());
        }
    }

    @Test
    void shouldThrowExceptionWhenCheckSizeOnPageAndSizeOnPageIsLessThanZero() {

        //given
        int sizeOnPage = -5;
        int maxSize = 3;

        //when
        try {
            operationServiceHelper.checkSizeOnPage(sizeOnPage, maxSize);
        } catch (OperationException exception) {

            //then
            assertEquals("Parameter size on page is to small.", exception.getOperationError().getMessage());
        }
    }

    @Test
    void shouldReturnMaxSizeWhenCheckSizeOnPageAndSizeOnPageIsZero() {

        //given
        int sizeOnPage = 0;
        int maxSize = 3;

        //when
        int result = operationServiceHelper.checkSizeOnPage(sizeOnPage, maxSize);

        //then
        assertEquals(3, result);
    }

    @Test
    void shouldReturnSizeWhenCheckSizeOnPage() {

        //given
        int size = 2;

        //when
        int result = operationServiceHelper.checkPageNumber(size);

        //then
        assertEquals(2, result);
    }
}