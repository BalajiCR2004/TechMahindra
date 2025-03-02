"use client";

import { useState } from "react";
import { HStack, Button, IconButton, Text } from "@chakra-ui/react";
import { HiChevronLeft, HiChevronRight } from "react-icons/hi";

interface PaginationProps {
  totalPages: number;
  currentPage: number;
  onPageChange: (page: number) => void;
}

const Pagination: React.FC<PaginationProps> = ({ totalPages, currentPage, onPageChange }) => {
  const goToPage = (page: number) => {
    if (page >= 1 && page <= totalPages) {
      onPageChange(page);
    }
  };

  const renderPageNumbers = () => {
    const pageNumbers = [];
    for (let i = 1; i <= totalPages; i++) {
      if (i === 1 || i === totalPages || (i >= currentPage - 1 && i <= currentPage + 1)) {
        pageNumbers.push(
          <Button
            key={i}
            onClick={() => goToPage(i)}
            colorScheme={i === currentPage ? "blue" : "gray"}
            variant={i === currentPage ? "solid" : "outline"}
          >
            {i}
          </Button>
        );
      } else if (i === 2 || i === totalPages - 1) {
        pageNumbers.push(<Text key={i}>...</Text>);
      }
    }
    return pageNumbers;
  };

  return (
    <HStack spacing={2} justify="center" mt={4}>
      {/* Previous Button */}
      <IconButton
        icon={<HiChevronLeft />}
        isDisabled={currentPage === 1}
        onClick={() => goToPage(currentPage - 1)}
        aria-label="Previous Page"
      />

      {/* Page Numbers */}
      {renderPageNumbers()}

      {/* Next Button */}
      <IconButton
        icon={<HiChevronRight />}
        isDisabled={currentPage === totalPages}
        onClick={() => goToPage(currentPage + 1)}
        aria-label="Next Page"
      />
    </HStack>
  );
};

export default Pagination;
