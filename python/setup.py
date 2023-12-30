from setuptools import setup, find_packages

setup(
    name='maplestory-openapi',
    version='0.0.1',
    description='MapleStory OpenAPI',
    author='so99ynoodles',
    url='https://github.com/SpiralMoon/maplestory.openapi',
    long_description=open('README.md', 'r').read(),
    long_description_content_type='text/markdown',
    packages=find_packages(),
    license='MIT',
    python_requires='>=3.9',
)
