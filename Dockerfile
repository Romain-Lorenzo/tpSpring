name: CI/CD Pipeline
on:
push:
branches:
- main
pull_request:
branches:
- main
jobs:
build:
runs-on: ubuntu-latest
container:
image: maven:3.8.3-openjdk-17
steps:
- name: Checkout code
uses: actions/checkout@v2
- name: Build
run: mvn compile
test:
runs-on: ubuntu-latest
needs: build
container:
image: maven:3.8.3-openjdk-17
steps:
- name: Checkout code
uses: actions/checkout@v2
- name: Test
run: mvn test