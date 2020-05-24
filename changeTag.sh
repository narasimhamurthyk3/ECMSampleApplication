#!/bin/bash
sed "s/tagVersion/$1/g" deployment-template.yml > deployment.yml
