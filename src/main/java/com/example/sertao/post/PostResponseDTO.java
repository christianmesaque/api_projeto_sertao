package com.example.sertao.post;

public record PostResponseDTO(Long id, String image, String title, String text) {
    public PostResponseDTO(Post post) {
        this(post.getId(), post.getImage(), post.getTitle(), post.getText());
    }
}
